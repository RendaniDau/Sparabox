package com.sparabox.business;

import com.sparabox.domain.business.DashboardDto;

public interface DashboardFlow {
    DashboardDto getDashboard(String userId);
}
