/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.springbootjasper.service.impl;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.tienda.springbootjasper.commons.JasperReportManager;
import com.tienda.tienda.springbootjasper.enums.TipoReporteEnum;
import com.tienda.tienda.springbootjasper.model.ReporteVentasDTO;
import com.tienda.tienda.springbootjasper.service.api.ReporteVentasServiceAPI;

import net.sf.jasperreports.engine.JRException;

/**
 * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a>
 * @project demo-spring-boot-jasper
 * @class ReporteVentasServiceImpl
 * @description
 * @HU_CU_REQ
 * @date 24 sep. 2021
 */
@Service
public class ReporteVentasServiceImpl implements ReporteVentasServiceAPI {

	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;

	/**
	 * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a>
	 * @date 24 sep. 2021
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws JRException
	 * @see com.example.demospringbootjasper.service.api.ReporteVentasServiceAPI#obtenerReporteVentas(java.util.Map)
	 */
	@Override
	public ReporteVentasDTO obtenerReporteVentas(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "reporte_de_ventas";
		ReporteVentasDTO dto = new ReporteVentasDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}

}
