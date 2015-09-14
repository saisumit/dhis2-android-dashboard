/*
 * Copyright (c) 2015, University of Oslo
 *
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.hisp.dhis.android.dashboard.api.api;

import org.hisp.dhis.android.dashboard.api.controllers.common.IDataController;
import org.hisp.dhis.android.dashboard.api.models.dashboard.DashboardElement;
import org.hisp.dhis.android.dashboard.api.models.dashboard.DashboardItem;
import org.hisp.dhis.android.dashboard.api.models.interpretation.IInterpretationCommentService;
import org.hisp.dhis.android.dashboard.api.models.interpretation.IInterpretationElementService;
import org.hisp.dhis.android.dashboard.api.models.interpretation.IInterpretationService;
import org.hisp.dhis.android.dashboard.api.models.interpretation.Interpretation;
import org.hisp.dhis.android.dashboard.api.models.interpretation.InterpretationComment;
import org.hisp.dhis.android.dashboard.api.models.interpretation.InterpretationElement;
import org.hisp.dhis.android.dashboard.api.models.user.User;
import org.hisp.dhis.android.dashboard.api.network.APIException;

import java.util.List;

public final class InterpretationScope implements IDataController<Interpretation>,
        IInterpretationService, IInterpretationElementService, IInterpretationCommentService {
    private final IDataController<Interpretation> interpretationController;
    private final IInterpretationService interpretationService;
    private final IInterpretationElementService interpretationElementService;
    private final IInterpretationCommentService interpretationCommentService;

    public InterpretationScope(IDataController<Interpretation> interpretationController,
                               IInterpretationService interpretationService,
                               IInterpretationElementService interpretationElementService,
                               IInterpretationCommentService interpretationCommentService) {
        this.interpretationController = interpretationController;
        this.interpretationService = interpretationService;
        this.interpretationElementService = interpretationElementService;
        this.interpretationCommentService = interpretationCommentService;
    }

    @Override
    public void sync() throws APIException {
        interpretationController.sync();
    }

    @Override
    public void deleteComment(InterpretationComment comment) {
        interpretationCommentService.deleteComment(comment);
    }

    @Override
    public void updateCommentText(InterpretationComment comment, String text) {
        interpretationCommentService.updateCommentText(comment, text);
    }

    @Override
    public InterpretationElement createInterpretationElement(Interpretation interpretation,
                                                             DashboardElement dashboardElement, String mimeType) {
        return interpretationElementService.createInterpretationElement(interpretation, dashboardElement, mimeType);
    }

    @Override
    public InterpretationComment addComment(Interpretation interpretation, User user, String text) {
        return interpretationService.addComment(interpretation, user, text);
    }

    @Override
    public Interpretation createInterpretation(DashboardItem item, User user, String text) {
        return interpretationService.createInterpretation(item, user, text);
    }

    @Override
    public void updateInterpretationText(Interpretation interpretation, String text) {
        interpretationService.updateInterpretationText(interpretation, text);
    }

    @Override
    public void deleteInterpretation(Interpretation interpretation) {
        interpretationService.deleteInterpretation(interpretation);
    }

    @Override
    public void setInterpretationElements(Interpretation interpretation, List<InterpretationElement> elements) {
        interpretationService.setInterpretationElements(interpretation, elements);
    }

    @Override
    public List<InterpretationElement> getInterpretationElements(Interpretation interpretation) {
        return interpretationService.getInterpretationElements(interpretation);
    }
}