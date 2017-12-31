[[ChemotaxSim/images/TextTitle.JPG]]

**ChemotaxSim** is a basic simulator for bacterial chemotaxis through an attractant gradient (ex. nutrients).  It is designed as
an introductory demo or teaching tool for those new to the concept of chemotaxis.

Bacteria like *Escherichia coli* can't just sense where nutrients are in an environment - the distance across a single cell is too 
narrow to be able to detect any kind of concentration gradient.  So instead, bacteria use a "run-and-tumble" strategy to detect nutrients:
* **Run**: The cell moves in a straight line in whatever direction it's facing, taking periodic measurements of the nutrient
           concentration as it runs.  If the cell is moving towards an increased level of attractant (or decreased repellent),
           the switch to tumbling is repressed.  Conversely, if the cell moves towards decreased attractants (or increased repellent),
           the probability of tumbling is enhanced.  Runs can be as short as a fraction of a second to as long as over one minute.
* **Tumble**: The cell rotates for a random amount of time to face another direction.  This normally takes only a fraction of a second.

Using this strategy, bacteria are able to sense nutrients in an environment, move away from toxins and antibiotics, and evade
immune defenses in humans.

## Screenshots



## Sources

1. Sourjik, V., & Wingreen, N. (2012). Responding to chemical gradients: Bacterial chemotaxis. 
   *Current Opinion in Cell Biology*, 24(2), 262-268. doi:10.1016/j.ceb.2011.11.008
2. Webre, D. J., Wolanin, P. M., & Stock, J. B. (2003). Bacterial chemotaxis.
   *Current Biology*, 13(2), R47-R49. doi:10.1016/S0960-9822(02)01424-0
3. Thompson, C. (2017). Bacterial chemotaxis. University of British Columbia, Vancouver, BC,
   18 Oct 2017. (Lecture presentation, MICB 408: Advanced Bacterial Pathogenesis)
