package com.weixin.datacore.domain.weixin.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CDATAdapter extends XmlAdapter<String, String> {

	@Override
	public String unmarshal(String v) throws Exception {
		return v;
	}

	@Override
	public String marshal(String v) throws Exception {
		return "<![CDATA[" + v + "]]>";
	}

}
