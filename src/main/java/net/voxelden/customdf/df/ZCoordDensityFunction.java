package net.voxelden.customdf.df;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

public class ZCoordDensityFunction implements DensityFunction {
    public static ZCoordDensityFunction instance = new ZCoordDensityFunction();
    public static final CodecHolder<ZCoordDensityFunction> CODEC_HOLDER = CodecHolder.of(MapCodec.unit(instance));

    @Override
    public double sample(NoisePos pos) {
        return pos.blockZ() / 16d;
    }

    @Override
    public void fill(double[] densities, EachApplier applier) {
        applier.fill(densities, this);
    }

    @Override
    public DensityFunction apply(DensityFunctionVisitor visitor) {
        return visitor.apply(this);
    }

    @Override
    public double minValue() {
        return -1875000d;
    }

    @Override
    public double maxValue() {
        return 1875000d;
    }

    @Override
    public CodecHolder<? extends DensityFunction> getCodecHolder() {
        return CODEC_HOLDER;
    }
}
