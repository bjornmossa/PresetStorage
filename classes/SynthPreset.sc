SynthPreset {
  *new { | presetName, args, target, addAction=\addToHead |
    var defName;
    var localArgs;
    var fullArgs;

    if (PresetStorage.get(presetName).isNil, { Error("Preset"+presetName+"doesn't exist.\n").throw; });

    localArgs = args ? [];
    defName = PresetStorage.get(presetName)[\synth];
    fullArgs = PresetStorage.get(presetName)[\preset]++localArgs;

    ^Synth(defName, fullArgs, target.asTarget, addAction);
  }
}