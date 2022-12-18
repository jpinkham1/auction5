package com.togetherauction.model

abstract class ModelObject implements Comparable<ModelObject> {

	private Integer id

	ModelObject(final Integer id) {
		setId(id)
	}
	ModelObject() {
	}

	@Override
	String toString() {
		return getClass().getSimpleName() + String.valueOf(getId())
	}

	Integer getId() {
		return this.id
	}

	void setId(final Integer id) {
		this.id = id
	}

	@Override
	int compareTo(final ModelObject obj) {
		if (this == obj) {
			return 0
		}
		return id.compareTo(obj.getId())
	}

	@Override
	boolean equals(final Object obj) {
		if (obj == this) {
			return true
		}
		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false
		}
		final Integer otherId = ((ModelObject) obj).getId()
		if (id == null && otherId == null) {
			return true
		}
		if (id == null || otherId == null) {
			return false
		}
		return id.equals(otherId)
	}

	@Override
	int hashCode() {
		if (id == null) {
			return 0
		}
		return id.hashCode()
	}
	
}
