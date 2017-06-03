/**
 * 
 */
package com.suse.www.entity;

/**
 * @ClassName: Asset.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Dec 30, 2016 1:58:54 PM
 */
public class Asset {

	private int  id;
	private String asset_name;
	private String app_name;
	private int adapter_cluster_id;
	
	public Asset(){
		super();
	}
	public Asset(Integer  id,String asset_name,String app_name,int adapter_cluster_id){
		super();
		this.id = id;
		this.asset_name = asset_name;
		this.app_name = app_name;
		this.adapter_cluster_id = adapter_cluster_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public int getAdapter_cluster_id() {
		return adapter_cluster_id;
	}
	public void setAdapter_cluster_id(int adapter_cluster_id) {
		this.adapter_cluster_id = adapter_cluster_id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Asset: [ id="+id+" asset_name="+asset_name+" app_name="+app_name+" adapter_cluter_id="+adapter_cluster_id+ " ]";
	}
	
	
	
}
