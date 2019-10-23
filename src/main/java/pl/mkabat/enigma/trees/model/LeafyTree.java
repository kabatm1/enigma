package pl.mkabat.enigma.trees.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class LeafyTree extends Tree {

    public void makeNestFromLeaves() {
      log.info("making a nest from {} leaves", name);
    }

    public abstract void loseLeavesForWinter();
}
