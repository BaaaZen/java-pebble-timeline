package nl.palolem.timeline.util;

public abstract class AbstractBuilder<T extends Object, B extends AbstractBuilder<T, B>> {

	protected T object;

	protected B builder;

	protected abstract T newObject();

	protected abstract B builder();

	public abstract T build();

	public AbstractBuilder() {
		object = newObject();
		builder = builder();
	}

}
