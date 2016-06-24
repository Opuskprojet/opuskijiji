/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opusK.client.application.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePageView extends ViewWithUiHandlers<HomePageUiHandlers> implements HomePagePresenter.MyView {

    static private Logger logger = Logger.getLogger("HomePageView");

    @UiField
    SimplePanel mainContentPanel;


    public interface Binder extends UiBinder<Widget, HomePageView> {
    }

    @Inject
    public HomePageView(final Binder binder) {
        initWidget(binder.createAndBindUi(this));

        bindSlot(HomePagePresenter.SLOT_MAIN_CONTENT, mainContentPanel);
    }



}