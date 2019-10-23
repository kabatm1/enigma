package pl.mkabat.enigma.trees.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PineTree extends NeedleTree {

    @Override
    public void decorateForChristmas() {
        super.decorateForChristmas();
        log.info("specially decorating pine tree for christmas");
    }
}
