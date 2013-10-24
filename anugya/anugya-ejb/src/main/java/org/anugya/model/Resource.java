package org.anugya.model;

import java.io.Serializable;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "AN_RESOURCES")
public class Resource implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;

	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
	protected Resource parent;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "RESOURCE_TYPE", nullable = false)
	protected ResourceType resourceType;

	@OneToMany(mappedBy = "parent")
	private Collection<Resource> children;

}
