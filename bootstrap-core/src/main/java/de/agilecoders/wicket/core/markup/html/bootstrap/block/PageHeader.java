package de.agilecoders.wicket.core.markup.html.bootstrap.block;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.util.Attributes;
import de.agilecoders.wicket.core.util.Components;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * #### Description
 *
 * A simple shell for an h1 to appropriately space out and segment sections
 * of content on a page. It can utilize the h1's default small, element as
 * well most other components (with additional styles).
 *
 * documentation: http://getbootstrap.com/components/#page-header
 *
 * #### Usage
 *
 * ```java
 * PageHeader pageHeader = new PageHeader("id", Model.of("label text"))
 *                              .setSubtitle(Model.of("subtitle")); // add a sub title (optional)
 * add(pageHeader);
 * ```
 *
 * ```html
 * <div wicket:id="id"></div>
 * ```
 *
 * @author Michael Haitz <michael.haitz@agilecoders.de>
 */
public class PageHeader extends Panel {

    private final Label subtitle;

    /**
     * Construct.
     *
     * @param markupId The markup id
     */
    public PageHeader(final String markupId) {
        this(markupId, Model.of(""));
    }

    /**
     * Construct.
     *
     * @param markupId The markup id
     * @param model    The label of the page header
     */
    public PageHeader(final String markupId, final IModel<String> model) {
        super(markupId, model);

        BootstrapBaseBehavior.addTo(this);

        add(new Label("label", getDefaultModel()));
        add(subtitle = new Label("subtitle"));
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        checkComponentTag(tag, "div");
        Attributes.addClass(tag, "page-header");
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();

        Components.hideIfModelIsEmpty(subtitle);
    }

    /**
     * sets the subtitle.
     *
     * @param subtitle The subtitle as string
     * @return this component's instance
     */
    public final PageHeader setSubtitle(final String subtitle) {
        return setSubtitle(Model.of(subtitle));
    }

    /**
     * sets the subtitle model.
     *
     * @param subtitle The subtitle as model
     * @return this component's instance
     */
    public final PageHeader setSubtitle(final IModel<String> subtitle) {
        this.subtitle.setDefaultModel(subtitle);

        return this;
    }
}
