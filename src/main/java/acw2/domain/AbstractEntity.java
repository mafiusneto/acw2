package acw2.domain;

public abstract class AbstractEntity {
	
	public abstract Long getId();
	
	public abstract void setId(Long id);
	
	@Override
	public boolean equals(Object obj) {
		AbstractEntity entity = (AbstractEntity) obj; 
		return this.getId() == entity.getId();
	}
	
	public boolean hasValidId(){
		return getId() != null && getId() > 0;
	}

}
