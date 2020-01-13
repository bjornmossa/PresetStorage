PPreset {
  *new { | presetName, args |
    var defName;
    var localArgs;
    var fullArgs;

    if (PresetStorage.get(presetName).isNil, { Error("Preset"+presetName+"doesn't exist.\n").throw; });

	if (args.size.odd, { Error("PPreset events array should have even number of events.\n").throw; });

    localArgs = args ? [];
    defName = PresetStorage.get(presetName)[\synth];
    fullArgs = [\instrument, defName.asSymbol]++PresetStorage.get(presetName)[\preset]++localArgs;
	^Pbind(*fullArgs);
  }
}