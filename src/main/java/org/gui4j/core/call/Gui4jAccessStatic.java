package org.gui4j.core.call;

import java.util.Map;

import org.gui4j.exception.Gui4jUncheckedException;


final class Gui4jAccessStatic extends Gui4jAccessImpl
{
    private final Class mClass;

    Gui4jAccessStatic(ParseCtx parseCtx, String accessPath)
    {
        int startIndex = parseCtx.i;
        startIndex++; // accessPath.charAt(startIndex)=':'
        int endIndex = accessPath.indexOf('.', startIndex);
        if (endIndex == -1)
        {
            Object[] args = { accessPath, new Integer(startIndex)};
            throw new Gui4jUncheckedException.ResourceError(
                parseCtx.getConfigurationName(),
                parseCtx.getLineNumber(),
                RESOURCE_ERROR_access_unexpected_end,
                args);
        }
        String aliasName = accessPath.substring(startIndex, endIndex);
        parseCtx.i = endIndex;
        mClass = parseCtx.getClassForAliasName(aliasName);
        if (mClass == null)
        {
            Object[] args = { accessPath, aliasName };
            throw new Gui4jUncheckedException.ResourceError(
                parseCtx.getConfigurationName(),
                parseCtx.getLineNumber(),
                RESOURCE_ERROR_alias_not_defined_in_path,
                args);
        }
    }

    Class getResultClass()
    {
        return mClass;
    }

    public boolean isConstant()
    {
        return true;
    }

    public Object getValue(Object baseInstance, Object thisInstance, Map paramMap)
    {
        return null;
    }

}
