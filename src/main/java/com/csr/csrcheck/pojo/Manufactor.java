package com.csr.csrcheck.pojo;

import java.util.Objects;

/**
 * @description:厂家
 * @author: Administrator
 * @date: Created in 2019/10/14 15:55
 * @version:
 * @modified By:
 */
public class Manufactor {

    private int manufactor_id;          //主键，厂家编号
    private String manufactor_name;     //厂家名称
    private String manufactor_address;  //厂家地址
    private String business_license;    //营业执照路径
    private String business_licenselic; //营业执照服务器路径
    private String business_devices;    //医疗器械经营许可证路径
    private String business_deviceslic; //医疗器械经营许可证服务器路径

    public int getManufactor_id() {
        return manufactor_id;
    }

    public void setManufactor_id(int manufactor_id) {
        this.manufactor_id = manufactor_id;
    }

    public String getManufactor_name() {
        return manufactor_name;
    }

    public void setManufactor_name(String manufactor_name) {
        this.manufactor_name = manufactor_name;
    }

    public String getManufactor_address() {
        return manufactor_address;
    }

    public void setManufactor_address(String manufactor_address) {
        this.manufactor_address = manufactor_address;
    }

    public String getBusiness_license() {
        return business_license;
    }

    public void setBusiness_license(String business_license) {
        this.business_license = business_license;
    }

    public String getBusiness_licenselic() {
        return business_licenselic;
    }

    public void setBusiness_licenselic(String business_licenselic) {
        this.business_licenselic = business_licenselic;
    }

    public String getBusiness_devices() {
        return business_devices;
    }

    public void setBusiness_devices(String business_devices) {
        this.business_devices = business_devices;
    }

    public String getBusiness_deviceslic() {
        return business_deviceslic;
    }

    public void setBusiness_deviceslic(String business_deviceslic) {
        this.business_deviceslic = business_deviceslic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manufactor)) return false;
        Manufactor that = (Manufactor) o;
        return manufactor_id == that.manufactor_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufactor_id);
    }

    @Override
    public String toString() {
        return "Manufactor{" +
                "manufactor_id=" + manufactor_id +
                ", manufactor_name='" + manufactor_name + '\'' +
                ", manufactor_address='" + manufactor_address + '\'' +
                ", business_license='" + business_license + '\'' +
                ", business_licenselic='" + business_licenselic + '\'' +
                ", business_devices='" + business_devices + '\'' +
                ", business_deviceslic='" + business_deviceslic + '\'' +
                '}';
    }
}
