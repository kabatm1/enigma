package pl.mkabat.enigma.trees.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OakTree extends LeafyTree {

    @Override
    public void loseLeavesForWinter() {
        log.info("losing oak leaves for winter in november");
    }
}
