package de.agilecoders.wicket.core.markup.html.references;

import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * The {@link CssResourceReference} for the prettify component.
 *
 * @author miha
 * @deprecated Use {@link de.agilecoders.wicket.core.markup.html.bootstrap.block.prettyprint.PrettifyCssResourceReference} instead
 */
@Deprecated
public class BootstrapPrettifyCssReference extends CssResourceReference {
    private static final long serialVersionUID = 1L;

    /**
     * Singleton instance of this reference
     */
    public static final ResourceReference INSTANCE = new BootstrapPrettifyCssReference();

    /**
     * Private constructor.
     */
    private BootstrapPrettifyCssReference() {
        super(BootstrapPrettifyCssReference.class, "css/prettify.css");
    }

}
