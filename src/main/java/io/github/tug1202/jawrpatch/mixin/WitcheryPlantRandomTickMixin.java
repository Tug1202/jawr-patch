
/*
 * JAWR Patch
 * Copyright (C) 2026 Tug1202
 *
 * https://github.com/Tug1202
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.tug1202.jawrpatch.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraft.world.level.block.state.BlockState;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.tug1202.jawrpatch.JawrPatch;

import org.spongepowered.asm.mixin.Unique;

@Mixin(BlockBehaviour.class)
public class WitcheryPlantRandomTickMixin {

    @Unique
    private static final ResourceLocation GLINTWEED =
            ResourceLocation.fromNamespaceAndPath("witchery", "glintweed");

    @Unique
    private static final ResourceLocation EMBER_MOSS =
            ResourceLocation.fromNamespaceAndPath("witchery", "ember_moss");

    @Inject(
            method = "isRandomlyTicking",
            at = @At("HEAD"),
            cancellable = true
    )
    private void jawrPatch$isRandomlyTicking(
            BlockState state,
            CallbackInfoReturnable<Boolean> cir) {

        ResourceLocation id =
                BuiltInRegistries.BLOCK.getKey(state.getBlock());

        if (id.equals(GLINTWEED) || id.equals(EMBER_MOSS)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = "randomTick",
            at = @At("HEAD")
    )
    private void jawrPatch$randomTick(
            BlockState state,
            ServerLevel level,
            BlockPos pos,
            RandomSource random,
            CallbackInfo ci) {

        ResourceLocation id =
                BuiltInRegistries.BLOCK.getKey(state.getBlock());

        if (!id.equals(GLINTWEED) && !id.equals(EMBER_MOSS)) {
            return;
        }

        // 5% chance to attempt propagation.
        if (random.nextInt(20) != 0) {
            return;
        }

        // Choose a horizontal direction.
        int dx = random.nextInt(3) - 1;
        int dz = random.nextInt(3) - 1;

        // Don't choose the block we're already standing in.
        if (dx == 0 && dz == 0) {
            return;
        }

        BlockPos targetPos = pos.offset(dx, 0, dz);

        // Target must be empty.
        if (!level.isEmptyBlock(targetPos)) {
            return;
        }

        // The plant must be able to survive at the target.
        if (!state.canSurvive(level, targetPos)) {
            return;
        }

        // Place the same plant.
        level.setBlock(targetPos, state, 3);
    }
}