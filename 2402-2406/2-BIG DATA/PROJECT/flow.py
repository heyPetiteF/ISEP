import matplotlib.pyplot as plt
import matplotlib.patches as mpatches

# 创建一个数据流程图
fig, ax = plt.subplots(figsize=(12, 8))

# 数据源（API）
data_sources = plt.Circle((0.2, 0.8), 0.05, color='skyblue')
ax.add_patch(data_sources)
ax.text(0.2, 0.8, "API\n(Air Quality, Flu Data)", ha="center", va="center", fontsize=10)

# 数据摄取
data_ingestion = mpatches.FancyBboxPatch((0.4, 0.75), 0.2, 0.1, boxstyle="round,pad=0.1", edgecolor="black", facecolor="lightgreen")
ax.text(0.5, 0.8, "Data Ingestion\n(data_ingestion.py)", ha="center", va="center", fontsize=10)

# 数据湖存储
data_lake = mpatches.FancyBboxPatch((0.7, 0.75), 0.2, 0.1, boxstyle="round,pad=0.1", edgecolor="black", facecolor="lightgrey")
ax.text(0.8, 0.8, "Data Lake\n(Raw Data Storage)", ha="center", va="center", fontsize=10)

# 数据格式化和规范化
data_formatting = mpatches.FancyBboxPatch((0.2, 0.55), 0.2, 0.1, boxstyle="round,pad=0.1", edgecolor="black", facecolor="lightyellow")
ax.text(0.3, 0.6, "Data Formatting\n(data_formatting.py)", ha="center", va="center", fontsize=10)

data_normalization = mpatches.FancyBboxPatch((0.4, 0.55), 0.2, 0.1, boxstyle="round,pad=0.1", edgecolor="black", facecolor="lightyellow")
ax.text(0.5, 0.6, "Normalization\n(normalize_dates_to_utc.py)", ha="center", va="center", fontsize=10)

data_format_check = mpatches.FancyBboxPatch((0.6, 0.55), 0.2, 0.1, boxstyle="round,pad=0.1", edgecolor="black", facecolor="lightyellow")
ax.text(0.7, 0.6, "Format Check\n(with PySpark)", ha="center", va="center", fontsize=10)

# 数据合并
data_merging = mpatches.FancyBboxPatch((0.4, 0.35), 0.2, 0.1, boxstyle="round,pad=0.1", edgecolor="black", facecolor="lightcoral")
ax.text(0.5, 0.4, "Data Merging\n(merge_with_spark.py)", ha="center", va="center", fontsize=10)

# 模型训练和评估
model_training = mpatches.FancyBboxPatch((0.2, 0.15), 0.2, 0.1, boxstyle="round,pad=0.1", edgecolor="black", facecolor="lightpink")
ax.text(0.3, 0.2, "Model Training\n(train_and_evaluate_model.py)", ha="center", va="center", fontsize=10)

# 数据索引
data_indexing = mpatches.FancyBboxPatch((0.4, 0.15), 0.2, 0.1, boxstyle="round,pad=0.1", edgecolor="black", facecolor="lightsalmon")
ax.text(0.5, 0.2, "Data Indexing\n(data_indexing.py)", ha="center", va="center", fontsize=10)

# 数据展示（Dashboard）
data_dashboard = mpatches.FancyBboxPatch((0.7, 0.15), 0.2, 0.1, boxstyle="round,pad=0.1", edgecolor="black", facecolor="lightsteelblue")
ax.text(0.8, 0.2, "Dashboard\n(Kibana)", ha="center", va="center", fontsize=10)

# 添加箭头
ax.annotate('', xy=(0.3, 0.8), xytext=(0.25, 0.8), arrowprops=dict(arrowstyle="->"))
ax.annotate('', xy=(0.6, 0.8), xytext=(0.55, 0.8), arrowprops=dict(arrowstyle="->"))
ax.annotate('', xy=(0.9, 0.8), xytext=(0.85, 0.8), arrowprops=dict(arrowstyle="->"))

ax.annotate('', xy=(0.3, 0.65), xytext=(0.3, 0.6), arrowprops=dict(arrowstyle="->"))
ax.annotate('', xy=(0.5, 0.65), xytext=(0.5, 0.6), arrowprops=dict(arrowstyle="->"))
ax.annotate('', xy=(0.7, 0.65), xytext=(0.7, 0.6), arrowprops=dict(arrowstyle="->"))

ax.annotate('', xy=(0.5, 0.5), xytext=(0.5, 0.45), arrowprops=dict(arrowstyle="->"))

ax.annotate('', xy=(0.3, 0.3), xytext=(0.3, 0.25), arrowprops=dict(arrowstyle="->"))
ax.annotate('', xy=(0.5, 0.3), xytext=(0.5, 0.25), arrowprops=dict(arrowstyle="->"))
ax.annotate('', xy=(0.7, 0.3), xytext=(0.7, 0.25), arrowprops=dict(arrowstyle="->"))

# 调整显示范围
ax.set_xlim(0, 1)
ax.set_ylim(0, 1)
ax.axis('off')

plt.show()
