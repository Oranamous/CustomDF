package net.voxelden.customdf.df;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.densityfunction.DensityFunction;

public class DistanceFromCenterDensityFunction implements DensityFunction {
    public static DistanceFromCenterDensityFunction instance = new DistanceFromCenterDensityFunction();
    public static final CodecHolder<DistanceFromCenterDensityFunction> CODEC_HOLDER = CodecHolder.of(MapCodec.unit(instance));

    @Override
    public double sample(DensityFunction.NoisePos pos) {
        double x = pos.blockX() / 16d;
        double z = pos.blockZ() / 16d;
        return MathHelper.sqrt((float) (x * x + z * z));
    }

    @Override
    public void fill(double[] densities, DensityFunction.EachApplier applier) {
        applier.fill(densities, this);
    }

    @Override
    public DensityFunction apply(DensityFunction.DensityFunctionVisitor visitor) {
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
