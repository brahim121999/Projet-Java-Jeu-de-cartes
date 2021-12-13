package EtatSysteme;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import CodePrincipal.Systeme;

public abstract class EtatSysteme {
	public abstract void action(Systeme systeme) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException;
}
