package io.mywebsurfer.core.surfer.logic;

import java.util.List;

public interface Logic<R> {

  //Todo : for more surfing logic implement this interface than check method surf at InternetUser;

  List<R> apply(Object... objects) throws Exception;

}
