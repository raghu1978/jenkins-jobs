package ci_open_jenkins.build

import javaposse.jobdsl.dsl.DslFactory
import uk.gov.hmrc.jenkinsjobbuilders.domain.builder.BuildMonitorViewBuilder
import uk.gov.hmrc.jenkinsjobs.domain.builder.SbtMicroserviceJobBuilder
import uk.gov.hmrc.jenkinsjobs.domain.builder.SbtFrontendJobBuilder

new SbtFrontendJobBuilder('capital-gains-calculator-frontend').
        withScalaStyle().
        withSCoverage().
        withExtendedTimeout().
        build(this as DslFactory)

new SbtMicroserviceJobBuilder('capital-gains-calculator').
        withScalaStyle().
        withSCoverage().
        build(this as DslFactory)

new SbtMicroserviceJobBuilder('capital-gains-subscription').
        withScalaStyle().
        withSCoverage().
        build(this as DslFactory)

new SbtFrontendJobBuilder('capital-gains-subscription-frontend').
        withScalaStyle().
        withSCoverage().
        build(this as DslFactory)

new BuildMonitorViewBuilder('CGT-MONITOR')
        .withJobs('capital-gains-calculator-frontend','capital-gains-calculator','capital-gains-subscription', 'capital-gains-subscription-frontend').build(this)