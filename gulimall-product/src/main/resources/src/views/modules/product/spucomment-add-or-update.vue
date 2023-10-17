<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="sku_id" prop="skuId">
      <el-input v-model="dataForm.skuId" placeholder="sku_id"></el-input>
    </el-form-item>
    <el-form-item label="spu_id" prop="spuId">
      <el-input v-model="dataForm.spuId" placeholder="spu_id"></el-input>
    </el-form-item>
    <el-form-item label="å•†å“åå­—" prop="spuName">
      <el-input v-model="dataForm.spuName" placeholder="å•†å“åå­—"></el-input>
    </el-form-item>
    <el-form-item label="ä¼šå‘˜æ˜µç§°" prop="memberNickName">
      <el-input v-model="dataForm.memberNickName" placeholder="ä¼šå‘˜æ˜µç§°"></el-input>
    </el-form-item>
    <el-form-item label="æ˜Ÿçº§" prop="star">
      <el-input v-model="dataForm.star" placeholder="æ˜Ÿçº§"></el-input>
    </el-form-item>
    <el-form-item label="ä¼šå‘˜ip" prop="memberIp">
      <el-input v-model="dataForm.memberIp" placeholder="ä¼šå‘˜ip"></el-input>
    </el-form-item>
    <el-form-item label="åˆ›å»ºæ—¶é—´" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="åˆ›å»ºæ—¶é—´"></el-input>
    </el-form-item>
    <el-form-item label="æ˜¾ç¤ºçŠ¶æ€[0-ä¸æ˜¾ç¤ºï¼Œ1-æ˜¾ç¤º]" prop="showStatus">
      <el-input v-model="dataForm.showStatus" placeholder="æ˜¾ç¤ºçŠ¶æ€[0-ä¸æ˜¾ç¤ºï¼Œ1-æ˜¾ç¤º]"></el-input>
    </el-form-item>
    <el-form-item label="è´­ä¹°æ—¶å±žæ€§ç»„åˆ" prop="spuAttributes">
      <el-input v-model="dataForm.spuAttributes" placeholder="è´­ä¹°æ—¶å±žæ€§ç»„åˆ"></el-input>
    </el-form-item>
    <el-form-item label="ç‚¹èµžæ•°" prop="likesCount">
      <el-input v-model="dataForm.likesCount" placeholder="ç‚¹èµžæ•°"></el-input>
    </el-form-item>
    <el-form-item label="å›žå¤æ•°" prop="replyCount">
      <el-input v-model="dataForm.replyCount" placeholder="å›žå¤æ•°"></el-input>
    </el-form-item>
    <el-form-item label="è¯„è®ºå›¾ç‰‡/è§†é¢‘[jsonæ•°æ®ï¼›[{type:æ–‡ä»¶ç±»åž‹,url:èµ„æºè·¯å¾„}]]" prop="resources">
      <el-input v-model="dataForm.resources" placeholder="è¯„è®ºå›¾ç‰‡/è§†é¢‘[jsonæ•°æ®ï¼›[{type:æ–‡ä»¶ç±»åž‹,url:èµ„æºè·¯å¾„}]]"></el-input>
    </el-form-item>
    <el-form-item label="å†…å®¹" prop="content">
      <el-input v-model="dataForm.content" placeholder="å†…å®¹"></el-input>
    </el-form-item>
    <el-form-item label="ç”¨æˆ·å¤´åƒ" prop="memberIcon">
      <el-input v-model="dataForm.memberIcon" placeholder="ç”¨æˆ·å¤´åƒ"></el-input>
    </el-form-item>
    <el-form-item label="è¯„è®ºç±»åž‹[0 - å¯¹å•†å“çš„ç›´æŽ¥è¯„è®ºï¼Œ1 - å¯¹è¯„è®ºçš„å›žå¤]" prop="commentType">
      <el-input v-model="dataForm.commentType" placeholder="è¯„è®ºç±»åž‹[0 - å¯¹å•†å“çš„ç›´æŽ¥è¯„è®ºï¼Œ1 - å¯¹è¯„è®ºçš„å›žå¤]"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          skuId: '',
          spuId: '',
          spuName: '',
          memberNickName: '',
          star: '',
          memberIp: '',
          createTime: '',
          showStatus: '',
          spuAttributes: '',
          likesCount: '',
          replyCount: '',
          resources: '',
          content: '',
          memberIcon: '',
          commentType: ''
        },
        dataRule: {
          skuId: [
            { required: true, message: 'sku_id不能为空', trigger: 'blur' }
          ],
          spuId: [
            { required: true, message: 'spu_id不能为空', trigger: 'blur' }
          ],
          spuName: [
            { required: true, message: 'å•†å“åå­—不能为空', trigger: 'blur' }
          ],
          memberNickName: [
            { required: true, message: 'ä¼šå‘˜æ˜µç§°不能为空', trigger: 'blur' }
          ],
          star: [
            { required: true, message: 'æ˜Ÿçº§不能为空', trigger: 'blur' }
          ],
          memberIp: [
            { required: true, message: 'ä¼šå‘˜ip不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: 'åˆ›å»ºæ—¶é—´不能为空', trigger: 'blur' }
          ],
          showStatus: [
            { required: true, message: 'æ˜¾ç¤ºçŠ¶æ€[0-ä¸æ˜¾ç¤ºï¼Œ1-æ˜¾ç¤º]不能为空', trigger: 'blur' }
          ],
          spuAttributes: [
            { required: true, message: 'è´­ä¹°æ—¶å±žæ€§ç»„åˆ不能为空', trigger: 'blur' }
          ],
          likesCount: [
            { required: true, message: 'ç‚¹èµžæ•°不能为空', trigger: 'blur' }
          ],
          replyCount: [
            { required: true, message: 'å›žå¤æ•°不能为空', trigger: 'blur' }
          ],
          resources: [
            { required: true, message: 'è¯„è®ºå›¾ç‰‡/è§†é¢‘[jsonæ•°æ®ï¼›[{type:æ–‡ä»¶ç±»åž‹,url:èµ„æºè·¯å¾„}]]不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: 'å†…å®¹不能为空', trigger: 'blur' }
          ],
          memberIcon: [
            { required: true, message: 'ç”¨æˆ·å¤´åƒ不能为空', trigger: 'blur' }
          ],
          commentType: [
            { required: true, message: 'è¯„è®ºç±»åž‹[0 - å¯¹å•†å“çš„ç›´æŽ¥è¯„è®ºï¼Œ1 - å¯¹è¯„è®ºçš„å›žå¤]不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/product/spucomment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.skuId = data.spuComment.skuId
                this.dataForm.spuId = data.spuComment.spuId
                this.dataForm.spuName = data.spuComment.spuName
                this.dataForm.memberNickName = data.spuComment.memberNickName
                this.dataForm.star = data.spuComment.star
                this.dataForm.memberIp = data.spuComment.memberIp
                this.dataForm.createTime = data.spuComment.createTime
                this.dataForm.showStatus = data.spuComment.showStatus
                this.dataForm.spuAttributes = data.spuComment.spuAttributes
                this.dataForm.likesCount = data.spuComment.likesCount
                this.dataForm.replyCount = data.spuComment.replyCount
                this.dataForm.resources = data.spuComment.resources
                this.dataForm.content = data.spuComment.content
                this.dataForm.memberIcon = data.spuComment.memberIcon
                this.dataForm.commentType = data.spuComment.commentType
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/product/spucomment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'skuId': this.dataForm.skuId,
                'spuId': this.dataForm.spuId,
                'spuName': this.dataForm.spuName,
                'memberNickName': this.dataForm.memberNickName,
                'star': this.dataForm.star,
                'memberIp': this.dataForm.memberIp,
                'createTime': this.dataForm.createTime,
                'showStatus': this.dataForm.showStatus,
                'spuAttributes': this.dataForm.spuAttributes,
                'likesCount': this.dataForm.likesCount,
                'replyCount': this.dataForm.replyCount,
                'resources': this.dataForm.resources,
                'content': this.dataForm.content,
                'memberIcon': this.dataForm.memberIcon,
                'commentType': this.dataForm.commentType
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
