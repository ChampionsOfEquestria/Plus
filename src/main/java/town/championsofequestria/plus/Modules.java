package town.championsofequestria.plus;

import java.util.Locale;
import java.util.function.Function;

public enum Modules {

    // @formatter:off
    JAIL_INTERCEPTOR(JailInterceptor::new);
    // @formatter:on

    private final Function<PlusPlugin, Module> constructor;

    Modules(final Function<PlusPlugin, Module> constructor) {
        this.constructor = constructor;
    }

    public Function<PlusPlugin, Module> getConstructor() {
        return constructor;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase(Locale.US).replace("_", "");
    }
}
