package com.example.vlad.tankwiki.presentation.modules;


public abstract class AbstractModuleFragment<T> extends ModuleFragment {
    abstract void init(final T module);
}
