package com.grpc.server.config.langdriver;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SelectLanguageDriver extends XMLLanguageDriver implements LanguageDriver {

    private static final Pattern pattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType){
        Matcher matcher = pattern.matcher(script);
        if (matcher.find()) {
            script = matcher.replaceAll("<foreach collection=\"$1\" item=\"_item\" open=\"(\" " +
                    "separator=\",\" close=\")\" >#{_item}</foreach>");
        }

        script = "<script>" + script + "</script>";
        return super.createSqlSource(configuration, script, parameterType);

    }


}
