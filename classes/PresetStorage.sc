PresetStorage {
  classvar <>store;

  *initClass {
    store = Dictionary.new;
  }

  *add {
    | name, synth, data |
    if (data.size.odd, { Error("data argument should have even number of events.\n").throw; });

    store.put(name, Dictionary.with(*[\synth->synth,\preset->data]));
  }

  *get {
    | name |
    ^store[name];
  }
}