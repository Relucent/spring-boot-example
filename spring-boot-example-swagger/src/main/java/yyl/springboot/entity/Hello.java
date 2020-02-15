package yyl.springboot.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Hello")
@SuppressWarnings("serial")
public class Hello implements Serializable {

	@ApiModelProperty(value = "主键", required = true, example = "1")
	@NotNull(message = "ID不能为空")
	private Long id;
	@ApiModelProperty(value = "名称", example = "Name")
	private String name;
	@ApiModelProperty(value = "数值", example = "Value")
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}