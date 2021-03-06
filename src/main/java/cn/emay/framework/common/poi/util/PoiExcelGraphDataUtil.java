/**
 * 
 */
package cn.emay.framework.common.poi.util;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import cn.emay.framework.common.poi.excel.graph.entity.ExcelGraph;
import cn.emay.framework.common.poi.excel.graph.entity.ExcelGraphElement;

/**
 * @author xfworld
 * @since 2016-1-4
 * @version 1.0
 * 构建特殊数据结构
 */
public class PoiExcelGraphDataUtil {

    /**
     * 构建获取数据最后行数  并写入到定义对象中
     * @param dataSourceSheet
     * @param graph
     */
    public static void buildGraphData(Sheet dataSourceSheet, ExcelGraph graph) {
        if (graph != null && graph.getCategory() != null && graph.getValueList() != null
            && graph.getValueList().size() > 0) {
            graph.getCategory().setEndRowNum(dataSourceSheet.getLastRowNum());
            for (ExcelGraphElement e : graph.getValueList()) {
                if (e != null) {
                    e.setEndRowNum(dataSourceSheet.getLastRowNum());
                }
            }
        }
    }

    /**
     * 构建多个图形对象
     * @param dataSourceSheet
     * @param graphList
     */
    public static void buildGraphData(Sheet dataSourceSheet, List<ExcelGraph> graphList) {
        if (graphList != null && graphList.size() > 0) {
            for (ExcelGraph graph : graphList) {
                buildGraphData(dataSourceSheet, graph);
            }
        }
    }

}
