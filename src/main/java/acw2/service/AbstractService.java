package acw2.service;

import java.util.List;

import acw2.domain.AbstractEntity;

public abstract class AbstractService<T extends AbstractEntity> {
	
	public abstract List<T> list();

}