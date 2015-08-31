package org.hisp.dhis.android.dashboard.api.models.interpretation;

import org.hisp.dhis.android.dashboard.api.models.common.IService;
import org.hisp.dhis.android.dashboard.api.models.dashboard.DashboardItem;
import org.hisp.dhis.android.dashboard.api.models.user.User;

import java.util.List;

/**
 * Created by arazabishov on 8/27/15.
 */
public interface IInterpretationService extends IService {
    InterpretationComment addComment(Interpretation interpretation, User user, String text);

    Interpretation createInterpretation(DashboardItem item, User user, String text);

    void updateInterpretationText(Interpretation interpretation, String text);

    void deleteInterpretation(Interpretation interpretation);

    void setInterpretationElements(Interpretation interpretation, List<InterpretationElement> elements);

    List<InterpretationElement> getInterpretationElements(Interpretation interpretation);
}
