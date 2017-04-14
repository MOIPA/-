package os.jlxy.tr.rewrite.core;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class MyLogHander extends Formatter { 
    @Override 
    public String format(LogRecord record) { 
            return record.getLevel() + ":" + record.getMessage()+"\n"; 
    } 
}