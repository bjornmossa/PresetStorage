SynthPreset {
  *new { | presetName, args, target, addAction=\addToHead |
    var defName;
    var localArgs;
    var fullArgs;

    if (PresetStorage.get(presetName).isNil, { Error("Preset"+presetName+"doesn't exist.\n").throw; });

    localArgs = args ? [];
    defName = PresetStorage.get(presetName)[\synth];
    fullArgs = Dictionary.newFrom(PresetStorage.get(presetName)[\preset])
                         .blend(Dictionary.newFrom(localArgs), 1)
                         .getPairs;

    ^Synth(defName, fullArgs, target.asTarget, addAction);
  }
}