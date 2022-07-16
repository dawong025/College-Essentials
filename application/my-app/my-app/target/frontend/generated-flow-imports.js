export const addCssBlock = function(block, before = false) {
 const tpl = document.createElement('template');
 tpl.innerHTML = block;
 document.head[before ? 'insertBefore' : 'appendChild'](tpl.content, document.head.firstChild);
};

import { css, unsafeCSS, registerStyles } from '@vaadin/vaadin-themable-mixin';
import $cssFromFile_0 from 'Frontend/themes/myapp/Account.css';
const $css_0 = typeof $cssFromFile_0  === 'string' ? unsafeCSS($cssFromFile_0) : $cssFromFile_0;
addCssBlock(`<style>${$css_0}</style>`);
import $cssFromFile_1 from 'Frontend/themes/myapp/shopping-cart.css';
const $css_1 = typeof $cssFromFile_1  === 'string' ? unsafeCSS($cssFromFile_1) : $cssFromFile_1;
addCssBlock(`<style>${$css_1}</style>`);
import $cssFromFile_2 from 'Frontend/themes/myapp/Home.css';
const $css_2 = typeof $cssFromFile_2  === 'string' ? unsafeCSS($cssFromFile_2) : $cssFromFile_2;
addCssBlock(`<style>${$css_2}</style>`);

import '@polymer/iron-icon/iron-icon.js';
import '@polymer/iron-list/iron-list.js';
import '@vaadin/accordion/theme/lumo/vaadin-accordion.js';
import '@vaadin/app-layout/theme/lumo/vaadin-app-layout.js';
import '@vaadin/app-layout/theme/lumo/vaadin-drawer-toggle.js';
import '@vaadin/avatar-group/theme/lumo/vaadin-avatar-group.js';
import '@vaadin/avatar/theme/lumo/vaadin-avatar.js';
import '@vaadin/board/vaadin-board-row.js';
import '@vaadin/board/vaadin-board.js';
import '@vaadin/button/theme/lumo/vaadin-button.js';
import '@vaadin/charts/theme/lumo/vaadin-chart.js';
import '@vaadin/checkbox-group/theme/lumo/vaadin-checkbox-group.js';
import '@vaadin/checkbox/theme/lumo/vaadin-checkbox.js';
import '@vaadin/combo-box/theme/lumo/vaadin-combo-box.js';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/confirm-dialog/theme/lumo/vaadin-confirm-dialog.js';
import '@vaadin/context-menu/theme/lumo/vaadin-context-menu.js';
import '@vaadin/cookie-consent/theme/lumo/vaadin-cookie-consent.js';
import '@vaadin/crud/src/vaadin-crud-edit-column.js';
import '@vaadin/crud/theme/lumo/vaadin-crud.js';
import '@vaadin/custom-field/theme/lumo/vaadin-custom-field.js';
import '@vaadin/date-picker/theme/lumo/vaadin-date-picker.js';
import '@vaadin/date-time-picker/theme/lumo/vaadin-date-time-picker.js';
import '@vaadin/details/theme/lumo/vaadin-details.js';
import '@vaadin/dialog/theme/lumo/vaadin-dialog.js';
import '@vaadin/email-field/theme/lumo/vaadin-email-field.js';
import '@vaadin/field-highlighter/theme/lumo/vaadin-field-highlighter.js';
import '@vaadin/flow-frontend/comboBoxConnector.js';
import '@vaadin/flow-frontend/confirmDialogConnector.js';
import '@vaadin/flow-frontend/contextMenuConnector.js';
import '@vaadin/flow-frontend/contextMenuTargetConnector.js';
import '@vaadin/flow-frontend/cookieConsentConnector.js';
import '@vaadin/flow-frontend/datepickerConnector.js';
import '@vaadin/flow-frontend/dialogConnector.js';
import '@vaadin/flow-frontend/dndConnector-es6.js';
import '@vaadin/flow-frontend/flow-component-renderer.js';
import '@vaadin/flow-frontend/gridConnector.js';
import '@vaadin/flow-frontend/gridProConnector.js';
import '@vaadin/flow-frontend/ironListConnector.js';
import '@vaadin/flow-frontend/ironListStyles.js';
import '@vaadin/flow-frontend/lit-renderer.ts';
import '@vaadin/flow-frontend/loginOverlayConnector.js';
import '@vaadin/flow-frontend/lumo-includes.ts';
import '@vaadin/flow-frontend/menubarConnector.js';
import '@vaadin/flow-frontend/messageListConnector.js';
import '@vaadin/flow-frontend/notificationConnector.js';
import '@vaadin/flow-frontend/selectConnector.js';
import '@vaadin/flow-frontend/vaadin-big-decimal-field.js';
import '@vaadin/flow-frontend/vaadin-grid-flow-selection-column.js';
import '@vaadin/flow-frontend/vaadin-time-picker/timepickerConnector.js';
import '@vaadin/flow-frontend/virtualListConnector.js';
import '@vaadin/form-layout/theme/lumo/vaadin-form-item.js';
import '@vaadin/form-layout/theme/lumo/vaadin-form-layout.js';
import '@vaadin/grid-pro/theme/lumo/vaadin-grid-pro-edit-column.js';
import '@vaadin/grid-pro/theme/lumo/vaadin-grid-pro.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-column-group.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-column.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-sorter.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-tree-toggle.js';
import '@vaadin/grid/theme/lumo/vaadin-grid.js';
import '@vaadin/horizontal-layout/theme/lumo/vaadin-horizontal-layout.js';
import '@vaadin/icon/vaadin-icon.js';
import '@vaadin/icons/vaadin-iconset.js';
import '@vaadin/integer-field/theme/lumo/vaadin-integer-field.js';
import '@vaadin/item/theme/lumo/vaadin-item.js';
import '@vaadin/list-box/theme/lumo/vaadin-list-box.js';
import '@vaadin/login/theme/lumo/vaadin-login-form.js';
import '@vaadin/login/theme/lumo/vaadin-login-overlay.js';
import '@vaadin/menu-bar/theme/lumo/vaadin-menu-bar.js';
import '@vaadin/message-input/theme/lumo/vaadin-message-input.js';
import '@vaadin/message-list/theme/lumo/vaadin-message-list.js';
import '@vaadin/notification/theme/lumo/vaadin-notification.js';
import '@vaadin/number-field/theme/lumo/vaadin-number-field.js';
import '@vaadin/password-field/theme/lumo/vaadin-password-field.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/polymer-legacy-adapter/template-renderer.js';
import '@vaadin/progress-bar/theme/lumo/vaadin-progress-bar.js';
import '@vaadin/radio-group/theme/lumo/vaadin-radio-button.js';
import '@vaadin/radio-group/theme/lumo/vaadin-radio-group.js';
import '@vaadin/rich-text-editor/theme/lumo/vaadin-rich-text-editor.js';
import '@vaadin/scroller/vaadin-scroller.js';
import '@vaadin/select/theme/lumo/vaadin-select.js';
import '@vaadin/split-layout/theme/lumo/vaadin-split-layout.js';
import '@vaadin/tabs/theme/lumo/vaadin-tab.js';
import '@vaadin/tabs/theme/lumo/vaadin-tabs.js';
import '@vaadin/text-area/theme/lumo/vaadin-text-area.js';
import '@vaadin/text-field/theme/lumo/vaadin-text-field.js';
import '@vaadin/time-picker/theme/lumo/vaadin-time-picker.js';
import '@vaadin/upload/src/vaadin-upload-file.js';
import '@vaadin/upload/theme/lumo/vaadin-upload.js';
import '@vaadin/vaadin-lumo-styles/color.js';
import '@vaadin/vaadin-lumo-styles/icons.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/typography.js';
import '@vaadin/vertical-layout/theme/lumo/vaadin-vertical-layout.js';
import '@vaadin/virtual-list/vaadin-virtual-list.js';