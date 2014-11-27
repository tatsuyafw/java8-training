package chapter3.exercise07;

import java.util.Comparator;

// できてないない
// 組み合わせての指定ができない
public class MyComparator {
	public static Comparator<String> comparatorGenerator(Key key) {
	    switch( key ) {
	    case ASC:
	        return (first, second) -> first.compareTo(second);
	    case DESC:
	        return (first, second) -> -1 * first.compareTo(second);
	    case CASE_SENSITIVE:
	        return (first, second) -> first.compareTo(second);
	    case IGNORE_CASE:
	        return (first, second) -> first.compareToIgnoreCase(second);
	    case WHITESPACE_SENSITIVE:
		    return (first, second) -> first.compareTo(second);
		case IGNORE_WHITESPACE:
		    return (first, second) -> {
		    //TODO 全角文字への対応
		        String noSpaceFirst  = first.replace(" ", "");
			    String noSpaceSecond = second.replace(" ", "");
			    return noSpaceFirst.compareTo(noSpaceSecond);
			};
		default:
		     assert false;
		     break;
	    }
	    return null;
	}

	// FIXME 一つの enum に複数の種類の key が含まれている
    enum Key {
    	ASC, DESC, CASE_SENSITIVE, IGNORE_CASE, WHITESPACE_SENSITIVE, IGNORE_WHITESPACE;
	}
}
