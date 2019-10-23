package pl.mkabat.enigma.trees.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class NeedleTree extends Tree {

    public void decorateForChristmas() {
        log.info("decorating tree for christmas");
    }
}
