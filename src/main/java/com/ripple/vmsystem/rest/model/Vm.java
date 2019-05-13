package com.ripple.vmsystem.rest.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Table(name = "vm")
public class Vm {
	
	@Id @GeneratedValue
	private @NonNull String id;
    private @NonNull String vmName;
    private @NonNull String os;
    private @NonNull String cpu;
    private @NonNull String ram;
	private @NonNull String hardDisk;
	private String purposeOfUsage;
    private String username;
	public String getVmName() {
		return vmName;
	}
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}
	public String getPurposeOfUsage() {
		return purposeOfUsage;
	}
	public void setPurposeOfUsage(String purposeOfUsage) {
		this.purposeOfUsage = purposeOfUsage;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
