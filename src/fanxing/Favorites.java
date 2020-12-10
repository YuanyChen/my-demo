package fanxing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyuanyuan
 * @company Sunline
 * @description
 * @create 2020/10/27 17:54
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance){
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "Java");
        favorites.putFavorite(Integer.class, 50);
        favorites.putFavorite(Class.class, Favorites.class);
        String favoriteString = favorites.getFavorite(String.class);
        Integer favoriteInteger = favorites.getFavorite(Integer.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getSimpleName());
    }

}
