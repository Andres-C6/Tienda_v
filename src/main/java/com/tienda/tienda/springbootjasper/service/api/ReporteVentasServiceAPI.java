
package com.tienda.tienda.springbootjasper.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.tienda.tienda.springbootjasper.model.ReporteVentasDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteVentasServiceAPI {
	
	/**
	 * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a> 
	 * @date 24 sep. 2021
	 * @description 
	 * @HU_CU_REQ 
	 * @param params
	 * @return
	 */
	ReporteVentasDTO obtenerReporteVentas(Map<String, Object> params) throws JRException, IOException, SQLException;

}
