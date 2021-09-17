/**********************************************************************************************************************
 * vmcat                                                                                                              *
 *                                                                                                                    *
 * Copyright (c) 2020 Mike Millson                                                                                    *
 *                                                                                                                    * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License       * 
 * v. 2.0 which is available at https://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0 which is    *
 * available at https://www.apache.org/licenses/LICENSE-2.0.                                                          *
 *                                                                                                                    *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0                                                                     *
 *                                                                                                                    *
 * Contributors:                                                                                                      *
 *    Mike Millson - initial API and implementation                                                                   *
 *********************************************************************************************************************/
package org.github.vmcat.util.jdk;

/**
 * <p>
 * Regular expression constants for safepoints.
 * </p>
 * 
 * @author <a href="mailto:mmillson@redhat.com">Mike Millson</a>
 * 
 */
public class Safepoint {

    /**
     * Defined triggers.
     * 
     * TODO: Split into GC vs. non-GC?
     */
    public enum Trigger {
        BULK_REVOKE_BIAS, CGC_OPERATION, CLEANUP, CMS_FINAL_REMARK, CMS_INITIAL_MARK, COLLECT_FOR_METADATA_ALLOCATION,
        //
        DEOPTIMIZE, ENABLE_BIASED_LOCKING, EXIT, FIND_DEADLOCKS, FORCE_SAFEPOINT,
        //
        G1_COLLECT_FOR_ALLOCATION, G1_INC_COLLECTION_PAUSE, GEN_COLLECT_FOR_ALLOCATION, GEN_COLLECT_FULL_CONCURRENT,
        //
        GET_ALL_STACK_TRACES, GET_THREAD_LIST_STACK_TRACES, IC_BUFFER_FULL, NO_VM_OPERATION,
        //
        PARALLEL_GC_FAILED_ALLOCATION, PARALLEL_GC_SYSTEM_GC, PRINT_JNI, PRINT_THREADS, REDEFINE_CLASSES, REVOKE_BIAS,
        //
        SHENANDOAH_DEGENERATED_GC, SHENANDOAH_FINAL_MARK_START_EVAC, SHENANDOAH_FINAL_UPDATE_REFS,
        //
        SHENANDOAH_INIT_MARK, SHENANDOAH_INIT_UPDATE_REFS, THREAD_DUMP, UNKNOWN
    };

    /**
     * <p>
     * Bulk operation when the compiler has to recompile previously compiled code due to the compiled code no longer
     * being valid (e.g. a dynamic object has changed) or with tiered compilation when client compiled code is replaced
     * with server compiled code.
     * </p>
     */
    public static final String BULK_REVOKE_BIAS = "BulkRevokeBias";

    /**
     * <p>
     * G1 Mark and Remark phases.
     * </p>
     */
    public static final String CGC_OPERATION = "CGC_Operation";

    /**
     * <p>
     * Various cleanup operations that require a safepoint: deflate monitors, update inline caches, compilation policy,
     * symbol table rehash, string table rehash, CLD purge, dictionary resize.
     * </p>
     */
    public static final String CLEANUP = "Cleanup";

    /**
     * <p>
     * CMS Final Remark.The second stop-the-world phase of the concurrent low pause collector. All live objects are
     * marked, starting with the objects identified in the CMS Initial Mark. This event does not do any garbage
     * collection. It rescans objects directly reachable from GC roots, processes weak references, and remarks objects.
     * </p>
     */
    public static final String CMS_FINAL_REMARK = "CMS_Final_Remark";

    /**
     * <p>
     * CMS Initial Mark. A phase of the concurrent low pause collector that identifies the initial set of live objects
     * directly reachable from GC roots. This event does not do any garbage collection, only marking of objects.
     * </p>
     */
    public static final String CMS_INITIAL_MARK = "CMS_Initial_Mark";

    /**
     * <p>
     * When the Metaspace is resized. The JVM has failed to allocate memory for something that should be stored in
     * Metaspace and does a full collection before attempting to resize the Metaspace.
     * </p>
     */
    public static final String COLLECT_FOR_METADATA_ALLOCATION = "CollectForMetadataAllocation";

    /**
     * <p>
     * When the compiler has to recompile previously compiled code due to the compiled code no longer being valid (e.g.
     * a dynamic object has changed) or with tiered compilation when client compiled code is replaced with server
     * compiled code.
     * </p>
     */
    public static final String DEOPTIMIZE = "Deoptimize";

    /**
     * <p>
     * Biased locking is an optimization to reduce the overhead of uncontested locking. It assumes a thread owns a
     * monitor until another thread tries to acquire it.
     * </p>
     * 
     * <p>
     * EnableBiasedLocking is the operation the JVM does on startup when BiasedLocking is enabled (default for JDK8 and
     * 11).
     * </p>
     * 
     * <p>
     * BiasedLocking is being disabled and deprecated in JDK 17, as it's typically not relevant to modern workloads:
     * https://bugs.openjdk.java.net/browse/JDK-8231265.
     * </p>
     */
    public static final String ENABLE_BIASED_LOCKING = "EnableBiasedLocking";

    /**
     * <p>
     * JVM exit.
     * </p>
     */
    public static final String EXIT = "Exit";

    /**
     * <p>
     * TODO:
     * </p>
     */
    public static final String FIND_DEADLOCKS = "FindDeadlocks";

    /**
     * <p>
     * TODO:
     * </p>
     */
    public static final String FORCE_SAFEPOINT = "ForceSafepoint";

    /**
     * <p>
     * TODO:
     * </p>
     */
    public static final String G1_COLLECT_FOR_ALLOCATION = "G1CollectForAllocation";

    /**
     * <p>
     * G1 incremental collection.
     * </p>
     */
    public static final String G1_INC_COLLECTION_PAUSE = "G1IncCollectionPause";

    /**
     * <p>
     * Generational collector allocation failure.
     * </p>
     */
    public static final String GEN_COLLECT_FOR_ALLOCATION = "GenCollectForAllocation";

    /**
     * <p>
     * Generational collector full concurrent collect? How can a concurrent collection require a safepoint?
     * </p>
     */
    public static final String GEN_COLLECT_FULL_CONCURRENT = "GenCollectFullConcurrent";

    /**
     * <p>
     * JVMTI method to get stack trace information in native code for all threads.
     * </p>
     */
    public static final String GET_ALL_STACK_TRACES = "GetAllStackTraces";

    /**
     * <p>
     * JVMTI methods to get stack trace information in native code for a list of threads.
     * </p>
     */
    public static final String GET_THREAD_LIST_STACK_TRACES = "GetThreadListStackTraces";

    /**
     * <p>
     * Safepoint for managing inline cache buffer when it is full (clear? resize?).
     * </p>
     */
    public static final String IC_BUFFER_FULL = "ICBufferFull";

    /**
     * <p>
     * Guaranteed safepoint to process non-urgent JVM operations. The interval is enabled by
     * <code>-XX:+UnlockDiagnosticVMOptions</code> and controlled by <code>-XX:GuaranteedSafepointInterval=N</code>
     * (default 300000 seconds = 5 minutes).
     * </p>
     */
    public static final String NO_VM_OPERATION = "no vm operation";

    /**
     * <p>
     * Parallel collection.
     * </p>
     */
    public static final String PARALLEL_GC_FAILED_ALLOCATION = "ParallelGCFailedAllocation";

    /**
     * <p>
     * Parallel collection initiated by explicit gc.
     * </p>
     */
    public static final String PARALLEL_GC_SYSTEM_GC = "ParallelGCSystemGC";

    /**
     * <p>
     * TODO:
     * </p>
     */
    public static final String PRINT_JNI = "PrintJNI";

    /**
     * <p>
     * Printing a stack trace.
     * </p>
     */
    public static final String PRINT_THREADS = "PrintThreads";

    /**
     * <p>
     * Redefining classes
     * </p>
     */
    public static final String REDEFINE_CLASSES = "RedefineClasses";

    /**
     * <p>
     * Biased locking is an optimization to reduce the overhead of uncontested locking. It assumes a thread owns a
     * monitor until another thread tries to acquire it.
     * </p>
     * 
     * <p>
     * RevokeBias is the operation the JVM does to undo the optimization when a different thread tries to acquire the
     * monitor.
     * </p>
     * 
     * <p>
     * BiasedLocking is being disabled and deprecated in JDK 17, as it's typically not relevant to modern workloads:
     * https://bugs.openjdk.java.net/browse/JDK-8231265.
     * </p>
     */
    public static final String REVOKE_BIAS = "RevokeBias";

    /**
     * <p>
     * Shenandoah degenerated gc.
     * </p>
     */
    public static final String SHENANDOAH_DEGENERATED_GC = "ShenandoahDegeneratedGC";

    /**
     * <p>
     * Shenandoah final mark.
     * </p>
     */
    public static final String SHENANDOAH_FINAL_MARK_START_EVAC = "ShenandoahFinalMarkStartEvac";

    /**
     * <p>
     * Shenandoah final update.
     * </p>
     */
    public static final String SHENANDOAH_FINAL_UPDATE_REFS = "ShenandoahFinalUpdateRefs";

    /**
     * <p>
     * Shenandoah initial mark.
     * </p>
     */
    public static final String SHENANDOAH_INIT_MARK = "ShenandoahInitMark";

    /**
     * <p>
     * Shenandoah initial update.
     * </p>
     */
    public static final String SHENANDOAH_INIT_UPDATE_REFS = "ShenandoahInitUpdateRefs";

    /**
     * <p>
     * Generating a thread dump.
     * </p>
     */
    public static final String THREAD_DUMP = "ThreadDump";

    /**
     * Get <code>Trigger</code> vm log literal.
     * 
     * @param trigger
     *            The trigger.
     * @return The trigger literal in the vm log line.
     */
    public static final String getTriggerLiteral(Trigger trigger) {
        String triggerLiteral = null;

        switch (trigger) {

        case BULK_REVOKE_BIAS:
            triggerLiteral = BULK_REVOKE_BIAS;
            break;
        case CLEANUP:
            triggerLiteral = CLEANUP;
            break;
        case CGC_OPERATION:
            triggerLiteral = CGC_OPERATION;
            break;
        case CMS_FINAL_REMARK:
            triggerLiteral = CMS_FINAL_REMARK;
            break;
        case CMS_INITIAL_MARK:
            triggerLiteral = CMS_INITIAL_MARK;
            break;
        case COLLECT_FOR_METADATA_ALLOCATION:
            triggerLiteral = COLLECT_FOR_METADATA_ALLOCATION;
            break;
        case DEOPTIMIZE:
            triggerLiteral = DEOPTIMIZE;
            break;
        case ENABLE_BIASED_LOCKING:
            triggerLiteral = ENABLE_BIASED_LOCKING;
            break;
        case EXIT:
            triggerLiteral = EXIT;
            break;
        case FIND_DEADLOCKS:
            triggerLiteral = FIND_DEADLOCKS;
            break;
        case FORCE_SAFEPOINT:
            triggerLiteral = FORCE_SAFEPOINT;
            break;
        case G1_COLLECT_FOR_ALLOCATION:
            triggerLiteral = G1_COLLECT_FOR_ALLOCATION;
            break;
        case G1_INC_COLLECTION_PAUSE:
            triggerLiteral = G1_INC_COLLECTION_PAUSE;
            break;
        case GEN_COLLECT_FOR_ALLOCATION:
            triggerLiteral = GEN_COLLECT_FOR_ALLOCATION;
            break;
        case GEN_COLLECT_FULL_CONCURRENT:
            triggerLiteral = GEN_COLLECT_FULL_CONCURRENT;
            break;
        case GET_ALL_STACK_TRACES:
            triggerLiteral = GET_ALL_STACK_TRACES;
            break;
        case GET_THREAD_LIST_STACK_TRACES:
            triggerLiteral = GET_THREAD_LIST_STACK_TRACES;
            break;
        case IC_BUFFER_FULL:
            triggerLiteral = IC_BUFFER_FULL;
            break;
        case NO_VM_OPERATION:
            triggerLiteral = NO_VM_OPERATION;
            break;
        case PARALLEL_GC_FAILED_ALLOCATION:
            triggerLiteral = PARALLEL_GC_FAILED_ALLOCATION;
            break;
        case PARALLEL_GC_SYSTEM_GC:
            triggerLiteral = PARALLEL_GC_SYSTEM_GC;
            break;
        case PRINT_JNI:
            triggerLiteral = PRINT_JNI;
            break;
        case PRINT_THREADS:
            triggerLiteral = PRINT_THREADS;
            break;
        case REDEFINE_CLASSES:
            triggerLiteral = REDEFINE_CLASSES;
            break;
        case REVOKE_BIAS:
            triggerLiteral = REVOKE_BIAS;
            break;
        case SHENANDOAH_DEGENERATED_GC:
            triggerLiteral = SHENANDOAH_DEGENERATED_GC;
            break;
        case SHENANDOAH_FINAL_MARK_START_EVAC:
            triggerLiteral = SHENANDOAH_FINAL_MARK_START_EVAC;
            break;
        case SHENANDOAH_FINAL_UPDATE_REFS:
            triggerLiteral = SHENANDOAH_FINAL_UPDATE_REFS;
            break;
        case SHENANDOAH_INIT_MARK:
            triggerLiteral = SHENANDOAH_INIT_MARK;
            break;
        case SHENANDOAH_INIT_UPDATE_REFS:
            triggerLiteral = SHENANDOAH_INIT_UPDATE_REFS;
            break;
        case THREAD_DUMP:
            triggerLiteral = THREAD_DUMP;
            break;

        default:
            throw new AssertionError("Unexpected trigger value: " + trigger);
        }
        return triggerLiteral;
    }

    /**
     * Identify the safepoint trigger.
     * 
     * @param trigger
     *            The Trigger String stored in the database.
     * @return The <code>Trigger</code>.
     */
    public static final Trigger identifyTrigger(String trigger) {
        if (Trigger.BULK_REVOKE_BIAS.name().matches(trigger))
            return Trigger.BULK_REVOKE_BIAS;
        if (Trigger.CGC_OPERATION.name().matches(trigger))
            return Trigger.CGC_OPERATION;
        if (Trigger.CLEANUP.name().matches(trigger))
            return Trigger.CLEANUP;
        if (Trigger.COLLECT_FOR_METADATA_ALLOCATION.name().matches(trigger))
            return Trigger.COLLECT_FOR_METADATA_ALLOCATION;
        if (Trigger.CMS_FINAL_REMARK.name().matches(trigger))
            return Trigger.CMS_FINAL_REMARK;
        if (Trigger.CMS_INITIAL_MARK.name().matches(trigger))
            return Trigger.CMS_INITIAL_MARK;
        if (Trigger.DEOPTIMIZE.name().matches(trigger))
            return Trigger.DEOPTIMIZE;
        if (Trigger.ENABLE_BIASED_LOCKING.name().matches(trigger))
            return Trigger.ENABLE_BIASED_LOCKING;
        if (Trigger.EXIT.name().matches(trigger))
            return Trigger.EXIT;
        if (Trigger.FIND_DEADLOCKS.name().matches(trigger))
            return Trigger.FIND_DEADLOCKS;
        if (Trigger.FORCE_SAFEPOINT.name().matches(trigger))
            return Trigger.FORCE_SAFEPOINT;
        if (Trigger.G1_COLLECT_FOR_ALLOCATION.name().matches(trigger))
            return Trigger.G1_COLLECT_FOR_ALLOCATION;
        if (Trigger.G1_INC_COLLECTION_PAUSE.name().matches(trigger))
            return Trigger.G1_INC_COLLECTION_PAUSE;
        if (Trigger.GEN_COLLECT_FOR_ALLOCATION.name().matches(trigger))
            return Trigger.GEN_COLLECT_FOR_ALLOCATION;
        if (Trigger.GEN_COLLECT_FULL_CONCURRENT.name().matches(trigger))
            return Trigger.GEN_COLLECT_FULL_CONCURRENT;
        if (Trigger.GET_ALL_STACK_TRACES.name().matches(trigger))
            return Trigger.GET_ALL_STACK_TRACES;
        if (Trigger.GET_THREAD_LIST_STACK_TRACES.name().matches(trigger))
            return Trigger.GET_THREAD_LIST_STACK_TRACES;
        if (Trigger.IC_BUFFER_FULL.name().matches(trigger))
            return Trigger.IC_BUFFER_FULL;
        if (Trigger.NO_VM_OPERATION.name().matches(trigger))
            return Trigger.NO_VM_OPERATION;
        if (Trigger.PARALLEL_GC_FAILED_ALLOCATION.name().matches(trigger))
            return Trigger.PARALLEL_GC_FAILED_ALLOCATION;
        if (Trigger.PARALLEL_GC_SYSTEM_GC.name().matches(trigger))
            return Trigger.PARALLEL_GC_SYSTEM_GC;
        if (Trigger.PRINT_JNI.name().matches(trigger))
            return Trigger.PRINT_JNI;
        if (Trigger.PRINT_THREADS.name().matches(trigger))
            return Trigger.PRINT_THREADS;
        if (Trigger.REDEFINE_CLASSES.name().matches(trigger))
            return Trigger.REDEFINE_CLASSES;
        if (Trigger.REVOKE_BIAS.name().matches(trigger))
            return Trigger.REVOKE_BIAS;
        if (Trigger.SHENANDOAH_DEGENERATED_GC.name().matches(trigger))
            return Trigger.SHENANDOAH_DEGENERATED_GC;
        if (Trigger.SHENANDOAH_FINAL_MARK_START_EVAC.name().matches(trigger))
            return Trigger.SHENANDOAH_FINAL_MARK_START_EVAC;
        if (Trigger.SHENANDOAH_FINAL_UPDATE_REFS.name().matches(trigger))
            return Trigger.SHENANDOAH_FINAL_UPDATE_REFS;
        if (Trigger.SHENANDOAH_INIT_MARK.name().matches(trigger))
            return Trigger.SHENANDOAH_INIT_MARK;
        if (Trigger.SHENANDOAH_INIT_UPDATE_REFS.name().matches(trigger))
            return Trigger.SHENANDOAH_INIT_UPDATE_REFS;
        if (Trigger.THREAD_DUMP.name().matches(trigger))
            return Trigger.THREAD_DUMP;

        // no idea what trigger is
        return Trigger.UNKNOWN;
    }

    /**
     * Convenience method for concatenating triggers into a regular expression. For example:
     * 
     * "(trigger1|trigger2|trigger3)"
     *
     * @return The <code>Trigger</code> regular expression.
     */
    public static final String triggerRegEx() {
        StringBuilder regex = new StringBuilder();
        regex.append("(");
        Safepoint.Trigger[] triggers = Safepoint.Trigger.values();
        boolean firstTrigger = true;
        for (int i = 0; i < triggers.length; i++) {
            if (triggers[i] != Trigger.UNKNOWN) {
                if (!firstTrigger) {
                    regex.append("|");
                } else {
                    firstTrigger = false;
                }
                regex.append(getTriggerLiteral(triggers[i]));
            }
        }
        regex.append(")");
        return regex.toString();
    }
}
