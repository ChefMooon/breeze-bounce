package com.chefmooon.breezebounce;

import com.chefmooon.breezebounce.common.registry.ModArmorMaterials;
import com.chefmooon.breezebounce.common.registry.ModEffects;
import com.chefmooon.breezebounce.common.registry.ModParticleTypes;
import com.chefmooon.breezebounce.common.registry.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BreezeBounce {
    public static final String MOD_ID = "breezebounce";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static void init() {
        ModEffects.init();
        ModSounds.init();
        ModParticleTypes.init();
        ModArmorMaterials.init();
    }
}
