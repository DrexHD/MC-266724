package me.drex.mc_266724.mixin;

import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Score;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(targets = "net.minecraft.world.scores.PlayerScores")
public abstract class PlayerScoresMixin {

  @Shadow @Final private Map<Objective, Score> scores;

  /**
   * @author Drex
   * @reason Fix https://bugs.mojang.com/browse/MC-266724
   */
  @Overwrite
  public boolean remove(Objective objective) {
    return this.scores.remove(objective) != null;
  }

}
