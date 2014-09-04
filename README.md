android-furry-fireworks
=======================

A reference implementation of a 
[Drawable](http://developer.android.com/reference/android/graphics/drawable/Drawable.html)
that when first displayed will animate-in as suggested in the Material design 
guidelines.

In the a Material world images get special treatment. The [design 
guidelines](http://www.google.com/design/spec/patterns/imagery-treatment.html#)
suggest images be loaded in the following manner.

> Rather than relying heavily on opacity shifts, illustrations and photographs may 
load and transition in 3 phases at staggered durations. The levels are adjusted 
for a low contrast exposure and desaturated in color. The final stage would be a
full color saturation, only after the opacity is at 100%. The lower contrast effect
is a combination of a shift in gamma and black output for darker images.
