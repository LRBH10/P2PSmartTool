package test;

import inria.smarttools.core.component.Container;
import inria.smarttools.core.component.STGenericActivator;

public class Activator extends STGenericActivator {

	public Activator() {
		resourceFileName = "/test/resources/test.cdml";
		bundleName = "test";
	}

	@Override
	public Container createComponent(final String componentId) {
		final TestContainer container = new TestContainer(
				componentId, resourceFileName);
		registerContainer(container);
		return container;
	}

}
