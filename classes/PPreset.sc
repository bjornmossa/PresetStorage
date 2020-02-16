PPreset {
  *new { | presetName, args |
    var defName;
    var localArgs;
    var blended;
    var fullArgs;

    if (PresetStorage.get(presetName).isNil, { Error("Preset"+presetName+"doesn't exist.\n").throw; });

	  if (args.size.odd, { Error("PPreset events array should have even number of events.\n").throw; });

    localArgs = args ? [];
    defName = PresetStorage.get(presetName)[\synth];
    blended = Dictionary.newFrom(PresetStorage.get(presetName)[\preset])
                        .blend(Dictionary.newFrom(localArgs), 1)
                        .getPairs;

    fullArgs = [\instrument, defName.asSymbol]++blended;

	^Pbind(*fullArgs);
  }
}