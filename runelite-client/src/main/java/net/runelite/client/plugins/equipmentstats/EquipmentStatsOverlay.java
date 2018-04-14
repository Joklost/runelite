package net.runelite.client.plugins.equipmentstats;

import net.runelite.api.Client;
import net.runelite.api.queries.BankItemQuery;
import net.runelite.api.queries.EquipmentItemQuery;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.QueryRunner;

import javax.inject.Inject;
import java.awt.*;
import static com.google.common.collect.ObjectArrays.concat;

public class EquipmentStatsOverlay extends Overlay {

    @Inject
    private QueryRunner queryRunner;

    @Inject
    private Client client;

    @Inject
    private TooltipManager toolTipManager;

    @Inject
    private ItemManager itemManager;

    @Inject
    private EquipmentStatsPlugin plugin;

    @Override
    public Dimension render(Graphics2D graphics) {
        if (client.isMenuOpen()) {
            return null;
        }

        WidgetItem[] items;
        WidgetItem[] inventory = queryRunner.runQuery(new InventoryWidgetItemQuery());

        Widget bankWidget = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
        Widget equipmentWidget = client.getWidget(WidgetInfo.EQUIPMENT);
        if (bankWidget != null && !bankWidget.isHidden()) {
            WidgetItem[] bankItems = queryRunner.runQuery(new BankItemQuery());
            items = concat(inventory, bankItems, WidgetItem.class);
        } else if (equipmentWidget != null && !equipmentWidget.isHidden()) {
            WidgetItem[] equippedItems = queryRunner.runQuery(new EquipmentItemQuery());
            items = concat(inventory, equippedItems, WidgetItem.class);
        } else {
            items = inventory;
        }

        Point mousePosition = new Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());

        for (WidgetItem item : items) {
            if (item.getCanvasBounds().contains(mousePosition)) {

                // TODO: Get from Web API
                String itemName = itemManager.getItemComposition(item.getId()).getName();
                EquipmentItem equipmentItem = plugin.getEquipmentItems().get(itemName);

                if (equipmentItem == null) {
                    return null;
                }

                if (equipmentItem.getCombatStats().isStatLess()) {
                    return null;
                }

                toolTipManager.add(new Tooltip(equipmentItem.buildTooltip()));

                return null;
            }
        }

        return null;
    }
}
