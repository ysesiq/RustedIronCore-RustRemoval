package moddedmite.rustedironcore.api.event.handler;

import moddedmite.rustedironcore.api.event.AbstractHandler;
import moddedmite.rustedironcore.api.event.listener.IArrowRegisterListener;
import moddedmite.rustedironcore.property.FloatProperty;
import net.minecraft.Material;

import java.util.Optional;
import java.util.Set;

public class ArrowRegisterHandler extends AbstractHandler<IArrowRegisterListener> {
    private final FloatProperty<Material> ArrowRecoveryChance = FloatProperty.of("ArrowRecoveryChance", 0.0F);

    private boolean registered;

    public void onRegister() {
        if (this.registered) return;
        this.listeners.forEach(x -> x.onRegister(ArrowRecoveryChance));
        this.registered = true;
    }

    public Set<Material> keySet() {
        return this.ArrowRecoveryChance.keySet();
    }

    public Optional<Float> match(Material material) {
        return this.ArrowRecoveryChance.getOptional(material);
    }
}