package com.cist.controlCarAudit.service;

import java.util.HashMap;

public interface ControlCarAuditService {
	/**
	 * 审核布控车辆
	 * @param param
	 * @return
	 */
	public int AuditControlCar(HashMap<String,Object> param);
}
