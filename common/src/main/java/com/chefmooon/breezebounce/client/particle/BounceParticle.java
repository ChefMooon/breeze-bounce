package com.chefmooon.breezebounce.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class BounceParticle extends TextureSheetParticle {
    private final SpriteSet spriteSet;
    protected BounceParticle(ClientLevel clientLevel, double d, double e, double f, double g, double h, double i, SpriteSet spriteSet) {
        super(clientLevel, d, e, f, g, h, i);

        this.gravity = 0.0F;
        this.spriteSet = spriteSet;
        this.xd *= 0.05F;
        this.yd *= 0.05F;
        this.zd *= 0.05F;
        this.quadSize = 0.1F * (this.random.nextFloat() * this.random.nextFloat() * 4.0F);
        this.lifetime = (int)(16.0 / ((double)this.random.nextFloat() * 0.8 + 0.2)) + 2;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.spriteSet);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
            return new BounceParticle(clientLevel, d, e, f, g, h, i, this.sprites);
        }
    }
}
